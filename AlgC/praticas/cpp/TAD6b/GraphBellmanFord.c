//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphBellmanFord - Bellman-Ford Alg. for the Shortest Paths Tree
//

#include "GraphBellmanFord.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"

struct _GraphBellmanFord {
    int *distance;
    int *predecessor;
    Graph *graph;
    unsigned int startVertex;
};

GraphBellmanFord *GraphBellmanFordExecute(Graph *g, unsigned int startVertex) {
    assert(g != NULL);
    assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

    GraphBellmanFord *bellmanFord =
            (GraphBellmanFord *) malloc(sizeof(struct _GraphBellmanFord));
    assert(bellmanFord != NULL);

    unsigned int numVertices = GraphGetNumVertices(g);

    bellmanFord->graph = g;

    bellmanFord->distance = (unsigned int *) calloc(numVertices, sizeof(int));
    bellmanFord->predecessor = (unsigned int *) calloc(numVertices, sizeof(int));

    for (int k = 0; k < numVertices; ++k) {
        bellmanFord->distance[k] = INT_MAX;
        bellmanFord->predecessor[k] = -1;
    }

    int relaxed = 1;
    bellmanFord->distance[startVertex] = 0;
    for (int i = 0; i < numVertices - 1 && relaxed; i++) {
        for (int u = 0; u < numVertices; u++) {
            int *neigh = GraphGetAdjacentsTo(bellmanFord->graph, u);
            int *weights = GraphGetDistancesToAdjacents(bellmanFord->graph, u);
            int numNeigh = neigh[0];
            for (int j = 1; j <= numNeigh; j++) {
                relaxed = 0;
                int v = neigh[j];
                int weight = weights[j];
                if (bellmanFord->distance[u] + weight < bellmanFord->distance[v]) {
                    bellmanFord->distance[v] = bellmanFord->distance[u] + weight;
                    bellmanFord->predecessor[v] = u;
                    relaxed = 1;
                }
            }
        }
    }
    return bellmanFord;
}


void GraphBellmanFordDestroy(GraphBellmanFord **p) {
    assert(*p != NULL);

    GraphBellmanFord *aux = *p;

    free(aux->distance);
    free(aux->predecessor);

    free(*p);
    *p = NULL;
}

// Getting the result

unsigned int GraphBellmanFordHasPathTo(const GraphBellmanFord *p,
                                       unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return (p->distance[v] != INT_MAX);
}

int GraphBellmanFordDistanceTo(const GraphBellmanFord *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return p->distance[v];
}

Stack *GraphBellmanFordPathTo(const GraphBellmanFord *p, unsigned int v) {
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

void GraphBellmanFordShowPath(const GraphBellmanFord *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    Stack *s = GraphBellmanFordPathTo(p, v);
    while (StackIsEmpty(s) == 0) {
        printf("%d ", StackPop(s));
    }

    printf(" --- Distance = %d", p->distance[v]);

    StackDestroy(&s);
}

void GraphBellmanFordDisplay(const GraphBellmanFord *p) {
    int numberOfVertex = GraphGetNumVertices(p->graph);
    for (int i = 0; i < numberOfVertex; ++i) {
        printf("%d", i);
        GraphBellmanFordShowPath(p->graph, i);
        printf("\n");
    }
}
