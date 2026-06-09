class Solution {
    class Pair {
        int pos, speed;

        Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            cars.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(cars, (a, b) -> b.pos - a.pos);

        int fleets = 0;
        double prevTime = 0;

        for (Pair car : cars) {
            double time = (double)(target - car.pos) / car.speed;

            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}