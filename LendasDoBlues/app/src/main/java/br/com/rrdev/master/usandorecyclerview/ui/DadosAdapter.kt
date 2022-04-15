package br.com.rrdev.master.usandorecyclerview.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.master.usandorecyclerview.R
import br.com.rrdev.master.usandorecyclerview.model.Dados
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class DadosAdapter(private val onItemClicked: (Dados) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<Dados> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return DadosViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.res_item_dados,parent,false)
       )
    }

    //popular as informações
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DadosViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }
    }
        // vai dizer quantos items o recycler vai mostrar
    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(dados: List<Dados>){
        this.items = dados
    }

    // aqui criamos a representação dos dados
    class DadosViewHolder (view:View):RecyclerView.ViewHolder(view){
        val musica = itemView.findViewById<TextView>(R.id.nomeMusica)
        val author = itemView.findViewById<TextView>(R.id.autormusica)
        val tabmail = itemView.findViewById<ImageView>(R.id.tabmail)

        fun bind(dados: Dados, onItemClicked: (Dados) -> Unit){
            musica.text = dados.title
            author.text = dados.author

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOption)
                    .load(dados.thumbnailUrl)
                    .into(tabmail)



                itemView.setOnClickListener{
                    onItemClicked(dados)
                }
        }

    }
}