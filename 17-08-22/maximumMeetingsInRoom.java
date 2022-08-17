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

class myComparator implements Comparator<Meeting>{
    public int compare(Meeting o1,Meeting o2){
        if(o1.end<o2.end){
            return -1;
        }
        else if(o1.end>o2.end){
             return 1;
        }
        return 0;
    }
} 
class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}

class Solution {
    public static void maxMeeting(ArrayList<Integer> meet,int n){
        ArrayList<Integer> temp=new ArrayList<>();
        int timeLimit=0;
        Collections.sort(meet,new myComparator());
        temp.add(meet.get(0).pos);
        for(int i=1;i<meet.size();i++){
            if(meet.get(start)>timeLimit){
                temp.add(meet.get(i).pos);
                timeLimit=meet.get(i).end;
            }
        }
        for(int i=0;i<meet.size();i++){
            meet.get(i)=meet.get(i)+1;
        }
        return meet;
    }
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Meeting> meet=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            meet.add(new Meeting(S[i],F[i],i));
        }
        ArrayList<Integer> res=maxmeeting(meet,meet.size());
        return res;
        
    }
}
        
