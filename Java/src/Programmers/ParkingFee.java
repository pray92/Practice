package Programmers;

import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

// 20:22 ~ 21:13

// 기본 시간,  기본 요금, 단위 시간, 단위 요금
// 출차 내역 없으면 23:59에 나간걸로 간주
// 누적 주차 시간이 기본 이하라면 기본 요금 청구
// 초과 시 기본 요금 + 초과 시간에 대해 단위 시간마다 단위 요금 청구
// 나누어 떨어지지 않으면 '올림' 처리
// 차량번호가 작은 자동차부터 청구할 주차 요금을 차례대로 출력
public class ParkingFee {

    public int defaultTime = 0;
    public int defaultFee = 0;
    public int unitTime = 0;
    public int unitFee = 0;

    private class ParkingInfo {
        private List<Integer> log = new ArrayList<Integer>();

        public ParkingInfo(String record){
            addLog(record);
        }

        public void addLog(String record){
            log.add(parseTime(record.substring(0, 5)));
        }

        public int getTotalFee() {
            // 짝이 안 맞으면 마지막 출차 시간 23:59 추가
            if(log.size() % 2 != 0){
                log.add(parseTime("23:59"));
            }

            int ret = defaultFee;

            int cumulativeTime = 0;
            for(int nIndex = 0; nIndex < log.size(); nIndex += 2){
                int inTime = log.get(nIndex);
                int outTime = log.get(nIndex + 1);
                cumulativeTime += (outTime - inTime);
            }

            if(defaultTime < cumulativeTime){
                int time = cumulativeTime - defaultTime;
                ret += (time % unitTime == 0) ? time / unitTime * unitFee : (time / unitTime + 1) * unitFee;
            }
            
            return ret;
        }

        private int parseTime(String strTime){
            int hour = Integer.parseInt(strTime.substring(0, 2));
            int min =  Integer.parseInt(strTime.substring(3, 5));
            return hour * 60 + min;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        // 기본 값 초기화
        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        // HH:MM #### {IN | OUT}
        TreeMap<String, ParkingInfo> parkingInfo = new TreeMap<String, ParkingInfo>();
        for(String record : records){
            String carNo = (record.substring(6, 10));
            if(parkingInfo.containsKey(carNo)){
                parkingInfo.get(carNo).addLog(record);
            } else{
                parkingInfo.put(carNo, new ParkingInfo(record));
            }
        }

        int[] answer = new int[parkingInfo.size()];
        int nIndex = 0;
        for(var info : parkingInfo.values()){
            answer[nIndex++] = info.getTotalFee();
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(new ParkingFee().solution(new int[]{180, 5000, 10, 600}, new String[]{
        "05:34 5961 IN", 
            "06:00 0000 IN", 
            "06:34 0000 OUT",
            "07:59 5961 OUT", 
            "07:59 0148 IN", 
            "18:59 0000 IN", 
            "19:09 0148 OUT",
            "22:59 5961 IN", 
            "23:00 5961 OUT"
        }).toString());
    }
}
