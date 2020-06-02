cmake_minimum_required(VERSION 3.15)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(cpp aula12/Graph.c aula12/Graph.h aula12/GraphBFSWithQueue.c aula12/GraphBFSWithQueue.h aula12/GraphDFSRec.c aula12/GraphDFSRec.h aula12/GraphDFSWithStack.c aula12/GraphDFSWithStack.h aula12/IntegersQueue.c aula12/IntegersStack.c aula12/IntegersQueue.h aula12/IntegersStack.h aula12/PriorityQueue.c aula12/PriorityQueue.cpp aula12/PriorityQueue.h aula12/SortedList.c aula12/SortedList.h aula12/example2.c)