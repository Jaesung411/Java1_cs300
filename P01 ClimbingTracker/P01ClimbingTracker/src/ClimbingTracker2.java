



//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Climbing Tracker
// Course:   CS 300 Fall 2021
//
// Author:   Kyungmin Park	
// Email:    kpark234@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jaesung Lim
// Partner Email:   jlim83@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class tracks the number of successes and failures a climber challenges the grade from V0 to V15.
 * @author kyungminpark
 */
public class ClimbingTracker2 {
	
	/**
	 * Set the size of array, Checks the index of the number of successes and failures in array.
	 * Since the array is designated as oversize so the remaining successful and failure indexes will be output as null.
	 * 
	 * @param array is the name of the trials that contain success and failure including null.
	 * @param num is the number of successes and failures in the array.
	 * @param grade is the stage of climbing between V0 and V15 that will go into the array.
	 * @return the size of the array designated as oversized.
	 */
	private static int helper(String[] array, int num, String grade){
		
		//num은 grad를 성공한 횟

		//input은 메서드에 들어갈때 크기
		//output은  메소드에 나오는 크기 
		int inputSize = 0;
		int outputSize = 0;
		
		if (num == array.length) {
			return num;
		}
		
		//inputSize 계산 
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				break;
			}
			inputSize++;
		}
		//array에
		for(int i = 0; i < num; i++) {
		    array[num+inputSize-1-i] = grade;
		}
	
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				break;
			}
			outputSize++;
		}
		if(!(grade==null)) {
			if(!(grade.charAt(0) == 'V' && Character.isDigit(grade.charAt(1)))) {
				
				return 0;
			}
			if(grade.charAt(1)==1) {
			if(!(grade.charAt(0) == 'V' && (grade.charAt(2) <= 5))) {
				return 0;
				}
			}
		}
		return outputSize;
		
	}
	/**
	 * Check the index of the number of success in the array.
	 * 
	 * @param send is an array of variables same as the array in the helper method. 
	 * @param numSend is that checks how many times the climber successes in the array.
	 * @param grade is the stage of climbing between V0 and V15.
	 * @return Call the helper method and return the number of successes for each step in the array.
	 */
	public static int sendClimb(String[] send, int numSend, String grade) {
		return helper(send, numSend, grade);
		
	}
	
	/**
	 * Check the index of the number of fail in the array.
	 * 
	 * @param fail is an array of variables same as the array in the helper method. 
	 * @param numFail is that checks how many times the climber fails in the array.
	 * @param grade is the stage of climbing between V0 and V15.
	 * @return Call the helper method and return the number of fails for each step in the array.
	 */
	public static int failClimb(String[] fail, int numFail, String grade) {
		return helper(fail, numFail, grade);
	}
	/**
	 * Checks the value that the average climb grade is divided by the most recent number of climbs in each of the send and fail arrays.
	 * 
	 * @param send is an array of variables same as the array in the helper method. 
	 * @param numSend is that checks how many times the climber succeeds in the array.
	 * @param fail is an array of variables same as the array in the helper method. 
	 * @param numFail is that checks how many times the climber fails in the array.
	 * @param historyLength is the most recent number of climbs in each of the send and fail arrays.
	 * @return the average climb grade is divided by historyLength.
	 */
	public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength) {
	double sum1 =0.0;
	double sum2 =0.0;

	int n = 0, m = 0;

	if(historyLength > numSend){
	    n = numSend;

	}else{
	    n = historyLength;
	}

	if(historyLength > numFail){
	    m = numFail;

	}else{
	    m = historyLength;
	}	
	
	for(int i = numSend-1; i > numSend-n-1 ; i--) {
		int temp1 = Integer.parseInt(send[i].substring(1));
		sum1 = sum1 + temp1;
		
	}
	for(int i = numFail-1; i > numFail-m-1 ; i--) {
		int temp2 = Integer.parseInt(fail[i].substring(1));
		sum2 = sum2 + temp2;
		
		
	}
	
	double av1 = sum1/n;
	double av2 = sum2/m;
	
	if(historyLength <= 0||(numSend==0&&numFail==0)) {
		return "Send: --" + "\n" + "Fail: --";
	}
	if(numSend == 0) {
		return "Send: --" + "\n" + "Fail: " + av2;
	}
	if(numFail == 0) {
		return "Send: " + av1 + "\n" + "Fail: --";
	}

	return "Send: " + av1 + "\n" + "Fail: " + av2;

	}
	/**
	 * Based on the array, and each failure is represented with a "-",
	 * each success is represented with a "+" and are listed second.
	 * 
	 * @param send is an array of variables same as the array in the helper method. 
	 * @param numSend is that checks how many times the climber succeeds in the array.
	 * @param fail is an array of variables same as the array in the helper method. 
	 * @param numFail is that checks how many times the climber fails in the array.
	 * @return Return the number of successes or failures that are represented with a "-" or "+", 
	 * However, if there are no attempts for a given grade, it displays empty.
	 */
	public static String getHistogram(String[] send, int numSend, String[] fail, int numFail) {
		
		
		//나중에 출력하려고 새로 만든부분
		String result = ""; //초기

		if ((numSend == 0) && (numFail == 0)) {
			return "Error: no data to display";
		}
		if ((numSend == 0) || (numFail == 0)) {
			
		}
		
		// 기준을 정하려고 maximum 구함
		
		
		int max = Integer.parseInt(send[0].substring(1)); // max 의 초기값 선
		for (int i = 0; i < send.length; i++) {
			if(send[i] == null) {
				break;
			}
			if (Integer.parseInt(send[i].substring(1)) > max) {
				max = Integer.parseInt(send[i].substring(1)); // new maximum
			}
		}
		for (int i = 0; i < fail.length; i++) {
			if(fail[i] == null) {
				break;
			}
			if (Integer.parseInt(fail[i].substring(1)) > max) {
				max = Integer.parseInt(fail[i].substring(1));
		
			}
		}

		// 결과를 프린트 하는 부분
		for(int i = 0; i <= max; i++) {
			//V0, V1, V2 출력
			String findStr = "V" + i;

			//계속 다음줄로 넘어가서 계속 그대로 추가
			result += findStr + ": ";

			int failCount = 0;
			int sendCount = 0;
			
			for(int j = 0; j<send.length; j++) {
				if(findStr.equals(send[j])) {
					sendCount++;
				}
			}
			for(int j = 0; j<fail.length; j++) {
				if(findStr.equals(fail[j])) {
					failCount++;
				}
			}
			//print
			for(int j = 0; j < failCount; j++) {
				result += "- ";
			}
			for(int j = 0; j < sendCount; j++) {
				result += "+ ";
			}
			// 줄바꾸려고 추가시킨 부분 그리고 return 부분은 지웠음
			result += "\n";
		}
		return result;
	}
		
			
}
