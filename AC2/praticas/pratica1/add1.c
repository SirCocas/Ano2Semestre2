void wait(int);
int main(void)
{
    int s = 0;
    int cnt = 0;
    char c;
    int isCounting = 1; //seria melhor se fosse bool mas em termos de asm é mais fácil trabalhar com inteiros
    do
    {
        putChar('\r');
        printInt(cnt, 10 | 3 << 16);
        putChar('\t');
        printInt(cnt, 2 | 8 << 16);
        wait(5);
        c = inkey();
        if (c == '+')
            s = 0;
        if (c == '-')
            s = 1;
        if (c == 'r')
            cnt = 0;
        if (c == 's')
        {
            if (isCounting == 1)
                isCounting = 0;
            else
                isCounting = 1;
        }
        if (isCounting == 1)
        {
            if (s == 0)
                cnt = (cnt + 1) & 0xFF;
            else
                cnt = (cnt - 1) & 0xFF;
        }
    } while (c != 'q');
    return 0;
}

void wait(int ts)
{
    int i;
    for (i = 0; i < 515000 * ts; i++)
        ;
}