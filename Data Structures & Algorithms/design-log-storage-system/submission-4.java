class LogSystem {
    private Map<Integer, String> log;

    public LogSystem() {
        log = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        log.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        int len = getGranularity(granularity);

        String startP = start.substring(0, len);
        String endP = end.substring(0, len);

        for (Map.Entry<Integer,String> entry : log.entrySet()) {
            int id = entry.getKey();
            String date = entry.getValue();

            String dateP = date.substring(0, len);

            if (dateP.compareTo(startP) >= 0 && dateP.compareTo(endP) <= 0) {
    res.add(id);
}
        }
        return res;


    }

    private int getGranularity(String granularity) {
        switch (granularity) {
            case "Year" : return 4;
            case "Month": return 7;
            case "Day": return 10;
            case "Hour": return 13;
            case "Minute": return 16;
            case "Second": return 19;
        }

        return 19;
    }
}