import java.util.Vector;


public class Pokedex
{
    public Player player;
    public Vector<Pokemon> pokemonOwned;
    
    public Pokedex(Player player)
    {
        this.player = player;
        pokemonOwned = new Vector<Pokemon>();
        System.out.println("Initial pokemon: " + pokemonOwned.toString());
    }
    
    public void addPokemon(Pokemon pokemon)
    {
        pokemonOwned.add(pokemon);
        System.out.println("Pokemon added to hand");
        System.out.println("Current hand: " + pokemonOwned.toString());
    }
    
    public boolean removePokemon(Pokemon pokemon)
    {
        return pokemonOwned.remove(pokemon);
    }
}
