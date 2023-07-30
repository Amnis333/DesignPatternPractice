interface PlayfulPet{
    public abstract String playwithPerson(Person p);  // ペットに関する説明を文字列で返します。
    public abstract String play(); // ペットの遊び方を表す文字列を返します。
    public abstract String playNoise(); // ペットが遊んでいるときの音を表す文字列を返します。
    public abstract double cost(); // ペットを1時間ごとにレンタルするのにかかる費用を返します。
    public abstract boolean likesActivity(String activity); // ペットが特定の活動をするのが好きかどうかを返します。
    public abstract boolean dislikesActivity(String activity); // ペットが特定の活動を嫌がるかどうかを返します。
    public abstract String doActivity(String activity); // あるアクティビティが発生したときに何が起こるかを記述した文字列を返します。
}