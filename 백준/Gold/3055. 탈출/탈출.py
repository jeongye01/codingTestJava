from collections import deque
r,c=map(int,input().split())
board=[]
x,y=0,0
dx=[0,-1,0,1]
dy=[-1,0,1,0]
q=deque()
goalX,goalY=0,0
# 비버의 굴은 'D'로, 고슴도치의 위치는 'S'
# 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'
for i in range(r):
  col=list(input())
  for j in range(c):
    if col[j]=="S":
      x,y=j,i
    if col[j]=="*":
      q.append((j,i,0))
    if col[j]=="D":
      goalX,goalY=j,i
      col[j]="."
  board.append(col)

q.append((x,y,0))

ans=0
def bfs():
  global q,board,ans
  
  while q:
    (xx,yy,t)=q.popleft()
    if yy==goalY and xx==goalX:
      ans=t
      return
    for d in range(4):
      nx,ny=xx+dx[d],yy+dy[d]
      if 0<=nx<c and 0<=ny<r and board[ny][nx]==".":
          if board[yy][xx]=="*":
            if ny==goalY and nx==goalX:
              continue
            board[ny][nx]="*"
          else:
            board[ny][nx]="S"
          q.append((nx,ny,t+1))
            
bfs()   
if ans==0:
  ans="KAKTUS"
print(ans)