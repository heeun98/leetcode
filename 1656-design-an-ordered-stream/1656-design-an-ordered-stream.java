class OrderedStream {

    private final String[] buffer;
    private int nextSeq = 1;

    public OrderedStream(int n) {
        buffer = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        buffer[idKey] = value; // 일단 저장

        List<String> result = new ArrayList<>();
        while (nextSeq < buffer.length && buffer[nextSeq] != null) {
            result.add(buffer[nextSeq]);
            nextSeq++;
        }
        return result;
    }
}