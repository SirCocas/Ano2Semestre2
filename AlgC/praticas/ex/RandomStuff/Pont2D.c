//
// Created by sofas on 30/04/2020.
//
#include <stdlib.h>
#include <stdio.h>

struct _2dpoint {
    int x;
    int y;
};

// The Date type. (To be used in clients.)
typedef struct _2dpoint Point2D;

Point2D* createPoint(int x, int y){
    Point2D* created = (malloc(sizeof(int)));
    created->x=x;
    created->y=y;
    return created;
}

Point2D* addPoint(Point2D* pt1, Point2D* pt2){
    int x = pt1->x + pt2->x;
    int y = pt1->y + pt2->y;
    return createPoint(x,y);
}

Point2D* subtract(Point2D* pt1, Point2D* pt2){
    int x = pt1->x - pt2->x;
    int y = pt1->y - pt2->y;
    return createPoint(x,y);
}

int equalPoints(Point2D* pt1, Point2D* pt2){
    return pt1->x == pt2->x && pt1->y == pt2->y;
}

int isScaled(Point2D* pt1, Point2D* pt2){
    return pt1->x/pt2->x == pt1->y/pt2->y;
}

void printPoint(Point2D* pd){
    printf("(%d, ", pd->x);
    printf("%d)\n", pd->y);
}
int main(void){
    Point2D* origin = createPoint(1,5);
    printPoint(origin);
    Point2D* secondPoint = createPoint(1,1);
    Point2D* result = addPoint(origin,secondPoint);
    printPoint(result);
    return 0;
}
