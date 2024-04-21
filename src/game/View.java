package game;

public class View {
    String[] viewLines;

    public View(int disks) {
        viewLines = new String[disks];
        for (int i = 0; i < disks; i++) {
            viewLines[i] = i + 1 + "   |   |";
        }
    }

    public void change(Tower valueOf, Tower valueTo) {
        String value = null;
        int x = valueOf.ordinal();
        int y = valueTo.ordinal();
        for (int i = 0; i < viewLines.length; i++) {
            String[] position = viewLines[i].split("   ");
            
            if (!position[x].equals("|") && value == null) {
                value = position[x];
                position[x] = "|";
                viewLines[i] = arrayInLine(position);
            }

            if (!position[y].equals("|") && value != null) {
                while (!position[y].equals("|")) {
                    i--;
                    position = viewLines[i].split("   ");
                }
                position[y] = value;
                viewLines[i] = arrayInLine(position);
                i = viewLines.length;
                return;
            }
            if (i == viewLines.length - 1 && value != null) {
                position[y] = value;
                viewLines[i] = arrayInLine(position);
                return;
            }
        }
    }

    public String arrayInLine(String[] arg) {
        String str = "";

        for (int i = 0; i < arg.length - 1; i++) {
                str += arg[i] + "   ";
        }
        str += arg[arg.length - 1];
        return str;
    }

    public String toString() {
        String str = "|   |   |\n";

        for (int i = 0; i < viewLines.length; i++) {
            str += viewLines[i] + "\n";
        }

        return str;
    }

}
