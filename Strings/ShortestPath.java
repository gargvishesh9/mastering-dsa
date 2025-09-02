public class ShortestPath {

    // Function to calculate shortest displacement from origin
    public static float shortestPath(String path) {
        int x = 0; // East-West displacement
        int y = 0; // North-South displacement

        for (char dir : path.toCharArray()) {
            switch (dir) {
                case 'N': y += 1; break;
                case 'S': y -= 1; break;
                case 'E': x += 1; break;
                case 'W': x -= 1; break;
                default: break; // ignore invalid directions
            }
        }

        // Displacement = √(x^2 + y^2)
        return (float) Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        String path1 = "NNESW";
        String path2 = "SSSWWNE";

        System.out.println("Displacement for path1: " + shortestPath(path1));
        System.out.println("Displacement for path2: " + shortestPath(path2));
    }
}

/*
-------------------------------
📘 Dry Run Example

Example 1: path = "NNESW"
Start at origin (0,0)

Step 1: 'N' → y = 1
Step 2: 'N' → y = 2
Step 3: 'E' → x = 1
Step 4: 'S' → y = 1
Step 5: 'W' → x = 0

Final coordinates: (x=0, y=1)
Displacement = √(0^2 + 1^2) = 1.0

Example 2: path = "SSSWWNE"
Step 1: 'S' → y = -1
Step 2: 'S' → y = -2
Step 3: 'S' → y = -3
Step 4: 'W' → x = -1
Step 5: 'W' → x = -2
Step 6: 'N' → y = -2
Step 7: 'E' → x = -1

Final coordinates: (x=-1, y=-2)
Displacement = √((-1)^2 + (-2)^2) = √5 ≈ 2.236
-------------------------------

📌 Explanation:
- Track x and y coordinates for East-West and North-South.
- For each direction:
    - N → y+1, S → y-1
    - E → x+1, W → x-1
- Displacement from origin = √(x^2 + y^2)
- Return as float.

⏱ Time Complexity: O(n) → n = length of path string
📦 Space Complexity: O(1)
-------------------------------
*/
