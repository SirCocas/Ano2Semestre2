//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphDijkstra - Dijkstra Alg for the Shortest Paths Tree
//

#include "GraphDijkstra.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "PriorityQueue.h"

struct _GraphDijkstra {
    int *distance;
    int *predecessor;
    Graph *graph;
    unsigned int startVertex;
};

// FOR THE PRIORITY QUEUE /////////////////////////////////////////////

// The items in the priority queue will be ID:PRIORITY pairs (type ITEM)

typedef struct {
    int id;   // item id (assigned automatically = index in ITEM array)
    int pri;  // item priority (assigned by the user)
} ITEM;

// The priority comparator for items.
int comparator(const void *p1, const void *p2) {
    return ((ITEM *) p1)->pri - ((ITEM *) p2)->pri;
}

// The printer for items.
void printer(void *p) {
    ITEM *pitem = (ITEM *) p;
    printf("%d:%d", pitem->id, pitem->pri);
}

///////////////////////////////////////////////////////////////////////

GraphDijkstra *GraphDijkstraExecute(Graph *g, unsigned int startVertex) {
    assert(g != NULL);
    assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

    GraphDijkstra *result = (GraphDijkstra *) malloc(sizeof(struct _GraphDijkstra));
    assert(result != NULL);

    unsigned int numVertices = GraphGetNumVertices(g);

    result->distance = malloc(numVertices * sizeof(int));
    result->predecessor = malloc(numVertices * sizeof(int));

    for (int i = 0; i < numVertices; ++i) {
        result->distance[i] = INT_MAX;
        result->predecessor[i] = -1;
    }

    result->graph = g;
    result->startVertex = startVertex;

    PriorityQueue *candidates = PriorityQueueCreate(numVertices, comparator, printer);

    int contains[numVertices];

    for (int j = 0; j < numVertices; ++j) {
        contains[j] = 0;
    }

    result->distance[startVertex] = 0;  //    Inicializar os rótulos dos vértices

    ITEM* item[numVertices];

    item[startVertex]->id = startVertex;
    item[startVertex]->pri = INT_MAX;
    PriorityQueueInsert(candidates, &item[startVertex]); //    conjCandidatos = { s }

    PriorityQueueDecreasePriority(candidates, &item[startVertex]);

    contains[startVertex] = 1;

    ITEM *u;
    while (!PriorityQueueIsEmpty(candidates)) {
        u = ((ITEM *) PriorityQueueGetMin(candidates));
        PriorityQueueRemoveMin(candidates);
        int *neigh = (GraphGetAdjacentsTo(g, u->id));
        int *weights = GraphGetDistancesToAdjacents(g, u->id);
        int numberOfNeigh = neigh[0];
        for (int i = 1; i < numberOfNeigh; ++i) {
            int v = neigh[i];
            int weight = weights[i];
            if (weight + result->distance[u->id] < result->distance[v]) {
                result->distance[v] = result->distance[u->id] + weight;

                result->predecessor[v] = u->id;

                if (contains[v] == 0) {
                    contains[v] = 1;
                    PriorityQueueInsert(candidates, &item[v]);
                    item[v]->id = v;
                    item[v]->pri = weight;
                } else {
                    PriorityQueueDecreasePriority(candidates,
                                                  &item[v]);
                }
            }
        }

    }
    return result;
}


void GraphDijkstraDestroy(GraphDijkstra **p) {
    assert(*p != NULL);

    GraphDijkstra *aux = *p;

    free(aux->distance);
    free(aux->predecessor);

    free(*p);
    *p = NULL;
}

// Getting the result

unsigned int GraphDijkstraHasPathTo(const GraphDijkstra *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return (p->distance[v] != INT_MAX);
}

int GraphDijkstraDistanceTo(const GraphDijkstra *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return p->distance[v];
}

Stack *GraphDijkstraPathTo(const GraphDijkstra *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    Stack *s = StackCreate(GraphGetNumVertices(p->graph));

    if (p->distance[v] == INT_MAX) {
        return s;
    }

    // Store the path
    for (unsigned int current = v; current != p->startVertex;
         current = p->predecessor[current]) {
        StackPush(s, current);
    }

    StackPush(s, p->startVertex);

    return s;
}

// DISPLAYING on the console

void GraphDijkstraShowPath(const GraphDijkstra *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    Stack *s = GraphDijkstraPathTo(p, v);

    while (StackIsEmpty(s) == 0) {
        printf("%d ", StackPop(s));
    }

    printf(" --- Distance = %d", p->distance[v]);

    StackDestroy(&s);
}

void GraphDijkstraDisplay(const GraphDijkstra *p) {
    int numberOfVertex = GraphGetNumVertices(p->graph);
    for (int i = 0; i < numberOfVertex; ++i) {
        printf("%d", i);
        GraphDijkstraShowPath(p->graph, i);
        printf("\n");
    }
}
