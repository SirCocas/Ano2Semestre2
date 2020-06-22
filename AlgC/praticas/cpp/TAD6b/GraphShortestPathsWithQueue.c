//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphShortestPathsWithQueue - QUEUE algorithm for the Shortest Paths Tree
//

#include "GraphShortestPathsWithQueue.h"


#include <math.h>
#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"
#include "IntegersQueue.h"

struct _GraphShortestPathsWithQueue {
    int *distance;
    int *predecessor;
    Graph *graph;
    unsigned int startVertex;
};

GraphShortestPathsWithQueue *GraphShortestPathsWithQueueExecute(
        Graph *g, unsigned int startVertex) {
    assert(g != NULL);
    assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

    GraphShortestPathsWithQueue *ShortestPathsWithQueue =
            (GraphShortestPathsWithQueue *) malloc(
                    sizeof(struct _GraphShortestPathsWithQueue));
    assert(ShortestPathsWithQueue != NULL);

    unsigned int numVertices = GraphGetNumVertices(g);

    ShortestPathsWithQueue->distance = malloc(sizeof(int) * numVertices);
    ShortestPathsWithQueue->predecessor = malloc(sizeof(int) * numVertices);
    for (int j = 0; j < numVertices; ++j) {
        ShortestPathsWithQueue->distance[j] = INT_MAX;
        ShortestPathsWithQueue->predecessor[j] = -1;
    }


    ShortestPathsWithQueue->graph = g;
    ShortestPathsWithQueue->startVertex = startVertex;

    int belongs[numVertices];
    for (int k = 0; k < numVertices; ++k) {
        belongs[k] = 0;
    }

    belongs[startVertex] = 1;

    Queue *candidates = QueueCreate(numVertices);
    QueueEnqueue(candidates, startVertex);



    ShortestPathsWithQueue->distance[startVertex] = 0;
    while (!QueueIsEmpty(candidates)) {
        int u = QueueDequeue(candidates);
        belongs[u] = 0;
        int *neighbours = GraphGetAdjacentsTo(g, u);
        int size = neighbours[0];
        for (int i = 1; i <= size; ++i) {
            int current = neighbours[i];
            int weight = GraphGetDistancesToAdjacents(ShortestPathsWithQueue->graph, u)[i];
            if (ShortestPathsWithQueue->distance[u] + weight < ShortestPathsWithQueue->distance[current]) {
                ShortestPathsWithQueue->distance[current] = ShortestPathsWithQueue->distance[u] + weight;
                ShortestPathsWithQueue->predecessor[current] = u;
                if (belongs[current] == 0) {
                    QueueEnqueue(candidates, current);
                    belongs[current] = 1;
                }
            }
        }
    }
    return ShortestPathsWithQueue;

}

void GraphShortestPathsWithQueueDestroy(GraphShortestPathsWithQueue **p) {
    assert(*p != NULL);

    GraphShortestPathsWithQueue *aux = *p;

    free(aux->distance);
    free(aux->predecessor);

    free(*p);
    *p = NULL;
}

// Getting the result

unsigned int GraphShortestPathsWithQueueHasPathTo(
        const GraphShortestPathsWithQueue *p, unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return (p->distance[v] != INT_MAX);
}

int GraphShortestPathsWithQueueDistanceTo(const GraphShortestPathsWithQueue *p,
                                          unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    return p->distance[v];
}

Stack *GraphShortestPathsWithQueuePathTo(const GraphShortestPathsWithQueue *p,
                                         unsigned int v) {
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

void GraphShortestPathsWithQueueShowPath(const GraphShortestPathsWithQueue *p,
                                         unsigned int v) {
    assert(0 <= v && v < GraphGetNumVertices(p->graph));

    Stack *s = GraphShortestPathsWithQueuePathTo(p, v);

    while (StackIsEmpty(s) == 0) {
        printf("%d ", StackPop(s));
    }

    printf(" --- Distance = %d", p->distance[v]);

    StackDestroy(&s);
}

void GraphShortestPathsWithQueueDisplay(const GraphShortestPathsWithQueue *p) {
    int numberOfVertex = GraphGetNumVertices(p->graph);
    for (int i = 0; i < numberOfVertex; ++i) {
        printf("%d", i);
        GraphShortestPathsWithQueueShowPath(p->graph, i);
        printf("\n");
    }
}
