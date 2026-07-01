class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.get(0).size();

        Queue<int[]> q=new LinkedList<>();
        
        boolean[][] visited=new boolean[n][n];


        if(grid.get(0).get(0)==1 || grid.get(n-1).get(n-1)==1)
        return 0;

        int d=1;
        int[][] min=new int[n][n];

        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    q.offer(new int[]{i,j});
                    min[i][j]=0;
                    visited[i][j]=true;
                }
            }

        }
        
        while(!q.isEmpty())
        {
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                 
                if(x+1<n && !visited[x+1][y])
                {
                    q.offer(new int[]{x+1,y});
                    visited[x+1][y]=true;
                    min[x+1][y]=d;
                }
               
                if(x-1>=0 && !visited[x-1][y])
                {
                    q.offer(new int[]{x-1,y});
                    visited[x-1][y]=true;
                    min[x-1][y]=d;
                }
                if(y+1<n && !visited[x][y+1])
                {
                    q.offer(new int[]{x,y+1});
                    visited[x][y+1]=true;
                    min[x][y+1]=d;
                }
                if(y-1>=0 && !visited[x][y-1])
                {
                    q.offer(new int[]{x,y-1});
                    visited[x][y-1]=true;
                    min[x][y-1]=d;
                }
            }
            d++;
        }
        /*for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(min[i][j]+"\t");

            System.out.println();
        }*/
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b[2],a[2]);
        });

        visited=new boolean[n][n];
        int minimum=min[0][0];

        pq.offer(new int[]{0,0,min[0][0]});

        while(!pq.isEmpty())
        {
            int[] u=pq.poll();

            int x=u[0];
            int y=u[1];

            int val=u[2];

            //System.out.println(Arrays.toString(u));

            visited[x][y]=true;
            minimum=Math.min(minimum,val);

            if(x==n-1 && y==n-1)
            return minimum;

                if(x+1<n && !visited[x+1][y])
                {
                    pq.offer(new int[]{x+1,y,min[x+1][y]});
                    visited[x+1][y]=true;
                }
                if(x-1>=0 && !visited[x-1][y])
                {
                    pq.offer(new int[]{x-1,y,min[x-1][y]});
                    visited[x-1][y]=true;
                }

                if(y+1<n && !visited[x][y+1])
                {
                    pq.offer(new int[]{x,y+1,min[x][y+1]});
                    visited[x][y+1]=true;
                }
                if(y-1>=0 && !visited[x][y-1])
                {
                    pq.offer(new int[]{x,y-1,min[x][y-1]});
                    visited[x][y-1]=true;
                }
        }
        return minimum;
        //process min.

    }
}