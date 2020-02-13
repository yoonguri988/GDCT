package 이도영;

import java.util.ArrayList;
import java.util.List;



/*
1
한 인터넷 쇼핑몰이 자동 쿠폰 적용 시스템을 도입하려고 합니다. 자동 쿠폰 적용 시스템은 고객이 구매할 물건들을 장바구니에 담으면, 자동으로 사용 가능한 할인 쿠폰들을 최대한 효율적으로 적용해서 고객이 지불할 돈을 최소화시켜주는 시스템입니다.

다음은 고객이 장바구니에 담은 물건들의 가격 및 수량, 사용 가능한 쿠폰들의 할인율 및 수량의 예시입니다.

물건 낱개 가격   수량
25,400   2개
10,000   1개
31,600   1개
쿠폰 할인율   수량
5%   3개
23%   2개
11%   2개
9%   5개
낱개의 물건마다 최대 1개의 쿠폰을 적용할 수 있고, 물건의 가격은 100원 단위로 증가하므로, 쿠폰 적용 후의 가격도 정수로 떨어지게 됩니다. 위의 예에서, 아래와 같이 쿠폰들을 적용하면 가장 저렴하게 물건들을 구매할 수 있습니다.

물건 낱개 가격   구매 수량   적용 쿠폰   할인 후 가격
25,400   2개   23% 쿠폰 1장, 11% 쿠폰 1장   19,558원(23% 쿠폰 적용) + 22,606원(11% 쿠폰 적용) = 42,164원
10,000   1개   11% 쿠폰 1장   8,900원
31,600   1개   23% 쿠폰 1장   24,332원
즉, 자동 쿠폰 적용 시스템을 도입하면 42,164 + 8,900 + 24,332 = 75,396원을 고객에게 청구하게 됩니다.

장바구니에 담긴 물건들의 정보가 담긴 배열 goods, 사용 가능한 쿠폰들의 정보가 담긴 배열 coupons가 매개변수로 주어집니다. 이때, 자동 쿠폰 적용 시스템을 적용해서 고객들에게 청구할 금액을 return 하도록 solution 함수를 완성해주세요.

제한 사항
goods는 2차원 배열 형태입니다.
goods의 행 길이(장바구니에 담은 물건의 종류)는 1 이상 100,000 이하입니다.
goods의 각 행은 [a, b] 형태입니다.
a는 물건의 낱개 가격입니다. (100 ≤ a ≤ 100,000, a는 자연수이고 100의 배수)
물건의 종류가 달라도, 가격은 같을 수 있습니다. 즉, 중복된 a 값이 주어질 수 있습니다.
b는 물건의 수량입니다. (1 ≤ b ≤ 10, b는 자연수)
coupons는 2차원 배열 형태입니다.
coupons의 행 길이(사용 가능한 쿠폰의 종류)는 1 이상 100 이하입니다.
coupons의 각 행은 [c, d] 형태입니다.
c는 쿠폰의 할인율입니다. (1 ≤ c ≤ 100, c는 자연수)
쿠폰의 종류가 다르면 할인율도 다릅니다. 즉, 중복된 c 값은 주어지지 않습니다.
d는 쿠폰의 수량입니다. (1 ≤ d ≤ 10,000, d는 자연수)
입출력 예
goods   coupons   result
[[25400, 2], [10000, 1], [31600, 1]]   [[5, 3], [23, 2], [11, 2], [9, 5]]   75396
[[3100, 2], [7700, 1], [3100, 2]]   [[33, 4]]   14490
입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2

물건 낱개 가격   구매 수량   적용 쿠폰   할인 후 가격
3,100   2개   33% 쿠폰 2장   2,077원 + 2,077원 = 4,154원
7,700   1개   33% 쿠폰 1장   5,159원
3,100   2개   33% 쿠폰 1장   2,077원(33% 쿠폰 적용) + 3,100원(쿠폰 미적용) = 5,177원
4154 + 5159 + 5177 = 14490을 return 해주어야 합니다.
*/
public class Coupang1 {
	// {a,b}로 입력이 넘어옴 조심
	 static public long solution(int[][] goods, int[][]coupons) {
	      long answer = 0;
	       int gCnt = 0, cCnt = 0;
	       List<Double> gds = new ArrayList<>();
	       List<Double> cps = new ArrayList<>();
	       for(int[] g : goods) {
	          gCnt += g[1];
	          for(int i = 0; i < g[1]; i++) {
	             gds.add((double)g[0]);
	          }
	       }
	       for(int[] c : coupons) {
	          cCnt += c[1];
	          for(int i = 0; i < c[1]; i++) {
	             cps.add((double)c[0]);
	          }
	       }
	       
	       gds.sort((a, b) -> {return (int)(b - a);});
	       cps.sort((a, b) -> {return (int)(b - a);});
	       for(int i = 0; i < gCnt; i++) {
	          if(i < cCnt) {
	             answer += (int)(gds.get(i) * (100 - cps.get(i)) / 100);
	          }else {
	             answer +=  gds.get(i);
	          }
	       }
	       return answer;
	    }
	   public static void main(String[] args) {
	      int[][] a = new int[][]{{25400, 2}, {10000, 1}, {31600, 1}};
	      int[][] b = new int[][]{{5, 3}, {23, 2}, {11, 2}, {9, 5}};
	      System.out.println(solution(a, b));
	   }
}
