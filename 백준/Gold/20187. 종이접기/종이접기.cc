#include <stdio.h>
#include <vector>
#define NMAX 10
using namespace std;
 
int N, H;
char c;
 
vector< char > inp;
int maps[1<<NMAX][1<<NMAX];
 
// 대칭값으로 변환
int convert(int val, int k) {
    if(k == 0) {
        switch(val) {
            case 0: return 2;
            case 1: return 3;
            case 2: return 0;
            default: return 1;
        }
    }
 
    else {
        switch(val) {
            case 0: return 1;
            case 1: return 0;
            case 2: return  3;
            default: return 2;
        }
    }
}
 
 
void sv(int idx, int i1, int i2, int j1, int j2) {
    if(idx == N*2) maps[i1][j1] = H;
    else {
        if(inp[idx] == 'U') {
            sv(idx+1, i1, (i1+i2)/2, j1, j2);
 
            for(int i=(i1+i2)/2+1;i<=i2;i++) {
                for(int j=j1;j<=j2;j++) {
                    maps[i][j] = convert(maps[(i1+i2) - i][j], 0);
                }
            }
        }
 
        else if(inp[idx] == 'D') {
            sv(idx+1, (i1+i2)/2+1, i2, j1, j2);
 
            for(int i=i1;i<=(i1+i2)/2;i++) {
                for(int j=j1;j<=j2;j++) {
                    maps[i][j] = convert(maps[(i1+i2) - i][j], 0);
                }
            }
        }
 
        else if(inp[idx] == 'R') {
            sv(idx+1, i1, i2, (j1+j2)/2+1, j2);
 
            for(int i=i1;i <=i2;i++) {
                for(int j=j1;j<=(j1+j2)/2;j++) {
                    maps[i][j] = convert(maps[i][(j1+j2) - j], 1);
                }
            }
        }
 
        else {
            sv(idx+1, i1, i2, j1, (j1+j2)/2);
 
            for(int i=i1;i<=i2;i++) {
                for(int j=(j1+j2)/2+1;j<=j2;j++) {
                    maps[i][j] = convert(maps[i][(j1+j2) - j], 1);
                }
            }
        }
    }
}
 
int main() {
    // 입력
    scanf("%d\n", &N);
    for(int i=0;i<N*2;i++) {
        scanf("%c ", &c);
        inp.push_back(c);
    }
    scanf("%d", &H);
 
    // solve
    sv(0, 1, 1<<N, 1, 1<<N);
    
    // 출력
    for(int i=1;i<=(1<<N);i++,puts(""))
        for(int j=1;j<=(1<<N);j++) printf("%d ", maps[i][j]);
        
}