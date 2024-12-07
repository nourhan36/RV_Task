package com.example.rv_task

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.rv_task.Constants.Companion.USERNAME_KEY
import com.example.rv_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val moviesAdapter by lazy { MoviesAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val username = intent.getStringExtra(USERNAME_KEY)
        binding.tvUsername.text = username.toString()

        binding.rvMovies.adapter = moviesAdapter
        moviesAdapter.updateList(getMovies())
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miMore -> {
                moviesAdapter.updateList(getMoreMovies())
                binding.rvMovies.scheduleLayoutAnimation()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                1,
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years.",
                9.3,
                "1994",
                R.drawable.shawshank_redemption
            ),
            Movie(
                2,
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.",
                9.2,
                "1972",
                R.drawable.the_godfather
            ),
            Movie(
                3,
                "The Dark Knight",
                "Batman raises the stakes in his war on crime.",
                9.0,
                "2008",
                R.drawable.the_dark_knight
            ),
            Movie(
                4,
                "The Godfather II",
                "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
                9.0,
                "1974",
                R.drawable.the_godfather_2
            ),
            Movie(
                5,
                "12 Angry Men",
                "A jury holdout attempts to prevent a miscarriage of justice.",
                9.0,
                "1957",
                R.drawable.twelve_angry_men
            ),
            Movie(
                6,
                "The Lord of the Rings: The Return of the King",
                "Gandalf and Aragorn lead the World of Men against Sauron's army.",
                9.0,
                "2003",
                R.drawable.lord_of_the_rings_return_of_the_king
            ),
            Movie(
                7,
                "Schindler's List",
                "In German-occupied Poland during World War II, Oskar Schindler saves Jewish refugees.",
                9.0,
                "1993",
                R.drawable.schindlers_list
            ),
            Movie(
                8,
                "Pulp Fiction",
                "The lives of two hitmen, a boxer, and a pair of robbers intertwine in four tales of violence.",
                8.9,
                "1994",
                R.drawable.pulp_fiction
            ),
            Movie(
                9,
                "The Lord of the Rings: The Fellowship of the Ring",
                "A young hobbit embarks on a quest to destroy a powerful ring.",
                8.9,
                "2001",
                R.drawable.lord_of_the_rings_fellowship_of_the_ring
            ),
            Movie(
                10,
                "The Good, the Bad and the Ugly",
                "A bounty hunting scam joins three men in pursuit of buried gold.",
                8.8,
                "1966",
                R.drawable.good_bad_ugly
            )
        )
    }

    private fun getMoreMovies(): List<Movie> {
        return listOf(
            Movie(
                1,
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years.",
                9.3,
                "1994",
                R.drawable.shawshank_redemption
            ),
            Movie(
                2,
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.",
                9.2,
                "1972",
                R.drawable.the_godfather
            ),
            Movie(
                3,
                "The Dark Knight",
                "Batman raises the stakes in his war on crime.",
                9.0,
                "2008",
                R.drawable.the_dark_knight
            ),
            Movie(
                4,
                "The Godfather II",
                "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
                9.0,
                "1974",
                R.drawable.the_godfather_2
            ),
            Movie(
                5,
                "12 Angry Men",
                "A jury holdout attempts to prevent a miscarriage of justice.",
                9.0,
                "1957",
                R.drawable.twelve_angry_men
            ),
            Movie(
                6,
                "The Lord of the Rings: The Return of the King",
                "Gandalf and Aragorn lead the World of Men against Sauron's army.",
                9.0,
                "2003",
                R.drawable.lord_of_the_rings_return_of_the_king
            ),
            Movie(
                7,
                "Schindler's List",
                "In German-occupied Poland during World War II, Oskar Schindler saves Jewish refugees.",
                9.0,
                "1993",
                R.drawable.schindlers_list
            ),
            Movie(
                8,
                "Pulp Fiction",
                "The lives of two hitmen, a boxer, and a pair of robbers intertwine in four tales of violence.",
                8.9,
                "1994",
                R.drawable.pulp_fiction
            ),
            Movie(
                9,
                "The Lord of the Rings: The Fellowship of the Ring",
                "A young hobbit embarks on a quest to destroy a powerful ring.",
                8.9,
                "2001",
                R.drawable.lord_of_the_rings_fellowship_of_the_ring
            ),
            Movie(
                10,
                "The Good, the Bad and the Ugly",
                "A bounty hunting scam joins three men in pursuit of buried gold.",
                8.8,
                "1966",
                R.drawable.good_bad_ugly
            ),
            Movie(
                11,
                "Forrest Gump",
                "The story of a man with a low IQ who achieves great things.",
                8.8,
                "1994",
                R.drawable.forrest_gump
            ),
            Movie(
                12,
                "The Lord of the Rings: The Two Towers",
                "Frodo and Sam continue their journey while the others prepare for war.",
                8.8,
                "2002",
                R.drawable.lord_of_the_rings_two_towers
            ),
            Movie(
                13,
                "Fight Club",
                "An insomniac forms an underground fight club.",
                8.8,
                "1999",
                R.drawable.fight_club
            ),
            Movie(
                14,
                "Inception",
                "A thief steals secrets through dream-sharing technology.",
                8.8,
                "2010",
                R.drawable.inception
            ),
            Movie(
                15,
                "Star Wars: Episode V - The Empire Strikes Back",
                "After the rebels are overpowered, Luke Skywalker begins Jedi training.",
                8.7,
                "1980",
                R.drawable.star_wars_empire_strikes_back
            )
        )
    }
}