cmake_minimum_required(VERSION 3.15)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(cpp TAD6b/IntegersQueue.c TAD6b/PriorityQueue.c  aula12/GraphDFSRec.c aula12/GraphDFSWithStack.c TAD6b/example3.c TAD6b/Graph.c TAD6b/GraphBellmanFord.c TAD6b/GraphDijkstra.c TAD6b/GraphShortestPathsWithQueue.c aula12/SortedList.c aula12/SortedList.h aula12/IntegersStack.c aula12/IntegersStack.h)