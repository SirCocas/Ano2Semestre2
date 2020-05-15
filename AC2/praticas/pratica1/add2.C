#define STR_MAX_SIZE 20

char *strcat(char *, char *);
char *strcpy(char *, char *);
int strlen(char *);

int main(void)
{
    static char str1[STR_MAX_SIZE + 1];
    static char str2[STR_MAX_SIZE + 1];
    static char str3[2 * STR_MAX_SIZE + 1];

    printStr("Introduza 2 strings: ");
    readStr(str1, STR_MAX_SIZE);
    readStr(str2, STR_MAX_SIZE);
    printStr("Resultados:\n");
    printInt(strlen(str1), 10);
    printInt(strlen(str2), 10);
    strcpy(str3, str1);
    printStr(strcat(str3, str2));
    printInt10(strcmp(str1, str2));
    return 0;
}

int strlen(char *s)
{
    int len;
    for (len = 0; *s != '\0'; len++, s++)
        ;
    return len;
}

char *strcpy(char *dst, char *src)
{
    char *p = dst;
    for (*dst = *src; dst != '\0'; dst++, src++))
        {
            *dst = *src;
        }
    return p;
}

char *strcat(char *dst, char *src)
{
    char *p = dst;
    for (; *dst != '\'0'; dst++)
        ;
    strcpy(dst, src);
    return p;
}

int strcmp(char *s1, char *s2)
{
    for (; (*s1 == *s2) && (*s1 != '\0'); s1++, s2++)
        ;
    return (*s1 - *s2);
}