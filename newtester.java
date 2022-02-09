package length;

public class newtester {
	
	public static int sum(int[][] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length;i++) {
		for(int k = 0; k < nums[i].length;k++) {
			sum += nums[i][k];
		}
		}
		return sum;
	}
	public static int[][] aad(int[][] nums,int inn,int[] num){
		int[] out = new int[nums[inn].length + num.length];
		for(int i = 0;i<(nums[inn].length + num.length);i++) {
			if(i < nums[inn].length) {
		out[i]= nums[inn][i] ;
			}else {
				out[i]= num[i-nums[inn].length];
			}
		}
		nums[inn] = out;
		return nums;
	}
	public static void main(String[] args) {
		int[][] nums = {{20,10,10,1},{-1,-2,3},{-43}};
		nums = aad(nums,0,new int[]{10,-4,-4});
		System.out.print(sum(nums));
	}

}
