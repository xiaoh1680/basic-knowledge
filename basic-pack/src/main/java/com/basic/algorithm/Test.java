package com.basic.algorithm;

import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

       static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        ListNode listNode = new ListNode(Integer.MIN_VALUE);
        int start=0;
        int len=lists.length;
        for(int i=0;i<len;i++){
            if(lists[i]!=null){
                listNode=lists[i];
                start=i;
                break;
            }
        }
        if (listNode.val == Integer.MIN_VALUE) {
            return null;
        }
        ListNode idx=listNode.next;
        for(int i=start+1;i<len;i++){
            while(idx.next!=null){
                idx=idx.next;
            }
            idx.next=lists[i];
        }
        int size=0;
        ListNode sTemp=listNode;
        while(sTemp!=null){
            sTemp=sTemp.next;
            size++;
        }
        while(size>0){
            size--;
            ListNode tmp=listNode;
            while(tmp!=null){
                ListNode next=tmp.next;
                if(next!=null&&tmp.val>next.val){
                    int val=tmp.val;
                    tmp.val=next.val;
                    next.val=val;
                }
                tmp=next;
            }
        }
        return listNode;
    }

        public  ListNode reverseKGroup(ListNode head, int k) {
            if(k==1){
                return head;
            }
            LinkedList<ListNode> list=new LinkedList<>();
            LinkedList<ListNode> tempList=new LinkedList<>();
            ListNode pre=new ListNode(1);
            while(head!=null){
                tempList.offerFirst(head);
                head=head.next;
                if(tempList.size()==k){
                    while(tempList.peek()!=null){
                        list.offerFirst(tempList.pollFirst());
                    }
                }
            }
            while(tempList.peek()!=null){
                list.offerFirst(tempList.pollLast());
            }
            ListNode temp=pre;
            while(list.peek()!=null){
                temp.next=list.pollLast();
                temp=temp.next;
            }
            temp.next = null;
            return pre.next;

        }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<4){
            return list;
        }
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int L=j+1;
                int R=len-1;
                while(L<R){
                    int add=nums[i]+nums[j]+nums[L]+nums[R];
                    if(add==-294967296){
                        L++;
                        R--;
                        continue;
                    }
                    int mu=target-nums[i]-nums[j]-nums[L]-nums[R];
                    if(mu==0){
                        list.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        L++;
                        R--;
                    }else if(mu>0){
                        L++;
                    }else if(mu<0){
                        R--;
                    }
                }

            }
        }
        return list;
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==1){
            return s;
        }
        int len=s.length();
        boolean[][] arr=new boolean[len][len];
        for(int i=0;i<len;i++){
            arr[i][i]=true;
        }
        int start=0;
        int max=1;
        for(int L=2;L<len;L++){
            for(int i=0;i<len;i++){
                int j=L+i-1;
                if(j>=len) break;
                if(L==2&&s.charAt(i)==s.charAt(j)){
                    arr[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j)&&arr[i+1][j-1]){
                    arr[i][j]=true;
                }else{
                    arr[i][j]=false;
                }

                if(arr[i][j]&&L>max){
                    max=L;
                    start=i;
                }
            }

        }
        return s.substring(start,start+max);
    }
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0;
        while(i<j){
            max=height[i] < height[j] ? (j - i) * height[i++]: (j - i) * height[j--];
        }
        return max;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len=strs.length;
        boolean[] tags=new boolean[len];
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<len;i++){
            List<String> list=new ArrayList<>();
            if(tags[i]){
                continue;
            }
            list.add(strs[i]);
            tags[i]=true;
            for(int j=i+1;j<len;j++){
                if(!tags[j]&&judgeAna(strs[i],strs[j])){
                    list.add(strs[j]);
                    tags[j]=true;
                }
            }
            res.add(list);
        }
        return res;
    }
    public boolean judgeAna(String s1,String s2){
        Map<Character,Integer> map=new HashMap<>();
        for(Character c:s1.toCharArray()){
            map.put(c,map.get(c)==null?1:map.get(c)+1);
        }
        for(Character c:s2.toCharArray()){
            if(map.get(c)==null){
                return false;
            }
            map.put(c,map.get(c)-1);
            if(map.get(c)<0){
                return false;
            }
        }
        for(Character key:map.keySet()){
            if(map.get(key)>0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagramss(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        if(len==0){
            return res;
        }
        boolean[] tags=new boolean[len];
        Stack<Integer> stack = new Stack<>();
        diff(nums, stack, 0, tags, res);
        return res;
    }

    private void diff(int[] nums, Stack<Integer> stack, int dep, boolean[] tags, List<List<Integer>> res) {
        if (dep > nums.length) {
            return;
        }
        if (dep == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tags[i]) {
                continue;
            }
            stack.push(nums[i]);
            tags[i] = true;
            diff(nums, stack, dep+1, tags, res);
            tags[i] = false;
            stack.pop();
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        Test test = new Test();
        test.judgeAna("tir","rti");
    }

}
