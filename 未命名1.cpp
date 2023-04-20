#include <stdio.h>
#include <stdlib.h>

bool test(int n,int x,int h_ori[10001],int jump){
    if(jump>=n)return true;

    int h[10001];
    for(int i=0;i<n-1;i++){
        h[i]=h_ori[i];
    }
 //   printf("%d\n",jump); 
 //   system("pause");
    for(int k=0;k<x*2;k++){
        //i代表当前所在下标0至(n-2),左岸-1下标，右岸下标n-1
        int index=-1;
        bool bol=true;
        for(int index=-1;index<=n-1&&bol;){
            if(index==n-1){
               break;
            }
            for(int i=index+jump;i>index;i--){
                if(index+jump>=n-1){
                    index=n-1;
                    break;
                }
                if(h[i]>0){         //有能跳的石头
                    h[i]--;
                    index=i;
                    break;
                }
                if(i==index+1){     //没有能跳的石头
                  	bol=false;
                    
                }
            }

        }
        if(bol==false)return false;
    }
    return true;
}


int main(int argc, char *argv[]){
    // 请在此输入您的代码
    int n,x;
    int h[10001];
    scanf("%d%d",&n,&x);

    for(int i=0;i<n-1;i++){
      scanf("%d",&h[i]);
    }
    
    int left=1,right=n;
    int mid;
    while(left<right){
        mid=(left+right)/2;
               // printf("%d %d",left,right);
        if(test(n,x,h,mid)){ //这里的s就是我们要搜索的数
          right=mid;
        }else{
          left=mid+1;
        }
    }
	
	printf("%d",left);
    return left;
}
