//
// Created by sofas on 11/02/2020.
//

#include<stdio.h>

int main(void) {
    char firstname[256];
    char lastname[256];
    printf("Insert first name: ");
    scanf("%s", firstname);
    printf("Insert last name: ");
    scanf("%s", lastname);
    printf("Hello %s %s !", firstname, lastname);
}

