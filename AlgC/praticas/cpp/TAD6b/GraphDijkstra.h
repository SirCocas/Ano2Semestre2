//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphDijkstra - Dijkstra Alg. for the Shortest Paths Tree
//

#ifndef _GRAPH_DIJKSTRA_
#define _GRAPH_DIJKSTRA_

#include "Graph.h"
#include "IntegersStack.h"

typedef struct _GraphDijkstra GraphDijkstra;

GraphDijkstra* GraphDijkstraExecute(Graph* g, unsigned int startVertex);

void GraphDijkstraDestroy(GraphDijkstra** p);

// Getting the result

unsigned int GraphDijkstraHasPathTo(const GraphDijkstra* p, unsigned int v);

int GraphDijkstraDistanceTo(const GraphDijkstra* p, unsigned int v);

Stack* GraphDijkstraPathTo(const GraphDijkstra* p, unsigned int v);

// DISPLAYING on the console

void GraphDijkstraShowPath(const GraphDijkstra* p, unsigned int v);

void GraphDijkstraDisplay(const GraphDijkstra* p);

#endif  // _GRAPH_DIJKSTRA_
