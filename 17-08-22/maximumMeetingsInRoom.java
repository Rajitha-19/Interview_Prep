/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be accommodated in the meeting room. Print all meeting numbers

Examples: 

Input : s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9} 
Output : 1 2 4 5 
First meeting [1, 2] 
Second meeting [3, 4] 
Fourth meeting [5, 7] 
Fifth meeting [8, 9]

Input : s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, 
f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 } 
Output : 6 7 1 

*/

//sort the times of meetings according to the end time and then compare the starting value of the current interval with the ending interval.

class myComparator implements Comparator<Meeting>{
    public int compare(Meeting o1,Meeting o2){
        return o1.end-o2.end;
    }
} 
class Meeting{
    int start;
    int end;
    Meeting(int start,int end){
        this.start=start;
        this.end=end;
    }
}

class Solution {
    public static int maxMeetings(int n,int[] S, int[] F) {
        // code here
        Meeting meet[]=new Meeting[n];
        for(int i=0;i<n;i++){
            meet[i]=new Meeting(S[i],F[i]);
        }
        Arrays.sort(meet,new myComparator());
        int res=1;
        int preVal=meet[0].end;
        for(int i=1;i<n;i++){
            if(meet[i].start>preVal){
                res++;
                preVal=meet[i].end;
            }
        }
        return res;
    }
}
