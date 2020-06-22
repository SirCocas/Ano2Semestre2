//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphBellmanFord - Bellman-Ford Alg. for the Shortest Paths Tree
//

#ifndef _GRAPH_BELLMAN_FORD_
#define _GRAPH_BELLMAN_FORD_

#include "Graph.h"
#include "IntegersStack.h"

typedef struct _GraphBellmanFord GraphBellmanFord;

GraphBellmanFord* GraphBellmanFordExecute(Graph* g, unsigned int startVertex);

void GraphBellmanFordDestroy(GraphBellmanFord** p);

// Getting the result

unsigned int GraphBellmanFordHasPathTo(const GraphBellmanFord* p,
                                       unsigned int v);

int GraphBellmanFordDistanceTo(const GraphBellmanFord* p, unsigned int v);

Stack* GraphBellmanFordPathTo(const GraphBellmanFord* p, unsigned int v);

// DISPLAYING on the console

void GraphBellmanFordShowPath(const GraphBellmanFord* p, unsigned int v);

void GraphBellmanFordDisplay(const GraphBellmanFord* p);

#endif  // _GRAPH_BELLMAN_FORD_
