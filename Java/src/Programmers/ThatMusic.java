package Programmers;

public class ThatMusic {

    private class MusicInfo{
        private int startHour = 0;
        private int startMin = 0;
        private int endHour = 0;
        private int endMin = 0;

        private String title = "";
        private String music = "";

        public MusicInfo(String stratTime, String endTime, String title, String music){
            String[] times = stratTime.split(":");
            startHour = Integer.parseInt(times[0]);
            startMin = Integer.parseInt(times[1]);
            times = endTime.split(":");
            endHour = Integer.parseInt(times[0]);
            endMin = Integer.parseInt(times[1]);

            this.title = title;
            this.music = convert(music);
        }

        public String getTitle(){
            return title;
        }

        public int getDuration(){
            return (endHour - startHour) * 60 + (endMin - startMin);
        }

        public String getRealMusic(){
            StringBuilder sb = new StringBuilder();
            for(int i = 0, j = 0; i < getDuration(); ++i){
                sb.append(music.charAt(j++ % music.length()));
                if(music.charAt(j % music.length()) == '#')
                    sb.append(music.charAt(j++ % music.length()));
            }
            return sb.toString();
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);
        int cachedDuration = 0;
        for(String info : musicinfos){
            String[] parsedInfo = info.split(",");
            MusicInfo musicInfo = new MusicInfo(parsedInfo[0], parsedInfo[1], parsedInfo[2], parsedInfo[3]);

            if(musicInfo.getRealMusic().contains(m)){
                if(cachedDuration < musicInfo.getDuration()){
                    answer = musicInfo.getTitle();
                    cachedDuration = musicInfo.getDuration();
                }
            }
        }

        if(answer.isEmpty())
            return "(None)";

        return answer;
    }

    private static String convert(String m){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m.length(); ++i){
            if(i < m.length() - 1 && m.charAt(i + 1) == '#'){
                sb.append((char)('a' + ('Z' - m.charAt(i++))));
            } else{
                sb.append(m.charAt(i));
            }
        }
        return sb.toString();
    }
}
