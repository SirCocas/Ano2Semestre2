//
// Created by sofas on 01/07/2020.
//


#include <stdio.h>
#include <stddef.h>

const int MaxDegree = 10;

Polynomial Max(int power, int power1);

typedef struct {
    int CoeffArray[MaxDegree + 1];
    int HighPower;
} *Polynomial;

void ZeroPolynomial(Polynomial Poly) {
    int i;
    for (int i = 0; i < MaxDegree; ++i) {
        Poly->CoeffArray[i] = 0;
    }
    Poly->HighPower = 0;
}

void AddPolynomial(const Polynomial Poly1, const Polynomial Poly2, Polynomial PolySum) {
    ZeroPolynomial(PolySum);
    PolySum = Max(Poly1->HighPower, Poly2->HighPower);

    for (int i = PolySum->HighPower; i >= 0; i--) {
        PolySum->CoeffArray[i] = Poly1->CoeffArray[i] + Poly2->CoeffArray[i];
    }
}

Polynomial Max(int power, int power1) {
    if (power > power1)
        return power;
    return power1;
}

void MultPolynomial(const Polynomial Poly1, const Polynomial Poly2, Polynomial PolyProd) {
    ZeroPolynomial(PolyProd);
    PolyProd->HighPower = Poly1->HighPower + Poly2->HighPower;
    if (PolyProd->HighPower > MaxDegree) {
        printf("Exceeded array size");
    } else {
        for (int i = 0; i <= Poly1->HighPower; i++) {
            for (int j = 0; j <= Poly2->HighPower; j++) {
                PolyProd->CoeffArray[i + j] += Poly1->CoeffArray[i] * Poly2->CoeffArray[j];
            }
        }
    }
}
