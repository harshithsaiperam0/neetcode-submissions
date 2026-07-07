class LogSystem {
    private Map<Integer, String> log;

    public LogSystem() {
        log = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        log.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();

        int len = getLength(granularity);

        String startPrefix = start.substring(0, len);
        String endPrefix = end.substring(0, len);

        for (Map.Entry<Integer, String> entry : log.entrySet()) {
            int id = entry.getKey();
            String timestamp = entry.getValue();

            String timePrefix = timestamp.substring(0, len);

            if (timePrefix.compareTo(startPrefix) >= 0 &&
                timePrefix.compareTo(endPrefix) <= 0) {
                result.add(id);
            }
        }

        return result;
    }

    private int getLength(String granularity) {
        switch (granularity) {
            case "Year":
                return 4;
            case "Month":
                return 7;
            case "Day":
                return 10;
            case "Hour":
                return 13;
            case "Minute":
                return 16;
            case "Second":
                return 19;
        }

        return 19;
    }
}