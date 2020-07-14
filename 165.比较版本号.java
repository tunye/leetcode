// https://leetcode-cn.com/problems/compare-version-numbers/
public class Solution {
    public static class Version {
        int main;
        int sub;
        int child1;
        int child2;

        public Version(String[] strings) {
            if (strings.length >= 1) {
                main = Integer.parseInt(strings[0]);
            }
            if (strings.length >= 2) {
                sub = Integer.parseInt(strings[1]);
            }
            if (strings.length >= 3) {
                child1 = Integer.parseInt(strings[2]);
            }
            if (strings.length >= 4) {
                child2 = Integer.parseInt(strings[3]);
            }
        }

        public int compare(Version v) {
            if (main > v.main) {
                return 1;
            } else if (main < v.main) {
                return -1;
            } else {
                if (sub > v.sub) {
                    return 1;
                } else if (sub < v.sub) {
                    return -1;
                } else {
                    if (child1 > v.child1) {
                        return 1;
                    } else if (child1 < v.child1) {
                        return -1;
                    } else {
                        if (child2 > v.child2) {
                            return 1;
                        } else if (child2 < v.child2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "Version{" +
                    "main=" + main +
                    ", sub=" + sub +
                    ", child1=" + child1 +
                    ", child2=" + child2 +
                    '}';
        }
    }

    public int compareVersion(String version1, String version2) {
        Version v1 = new Version(version1.split("\\."));
        Version v2 = new Version(version2.split("\\."));
        return v1.compare(v2);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.compareVersion("1.01","1"));
    }
}