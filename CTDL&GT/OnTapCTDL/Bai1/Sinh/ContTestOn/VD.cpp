#include <iostream>
using namespace std;
 
// function to convert decimal number to hexadecimal
void decToHexa(int n) { cout << hex << n << endl; }
 
// driver code
int main()
{
    int n = 374;
    decToHexa(n);
    return 0;
}
