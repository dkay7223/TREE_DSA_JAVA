public class Word {

    private String spell;
    private String meaning;

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }


    public Word(String spell, String meaning) {

        this.spell = spell;
        this.meaning = meaning;
    }


    public String toString(){
         return "Word : " + spell+ "  Meaning : "+ meaning;
    }
}
