import groovy.transform.Immutable
import groovy.transform.Sortable
import nextflow.io.ValueObject
import nextflow.util.KryoHelper
import nextflow.util.ArrayBag

@ValueObject
@Immutable(copyWith=true, knownImmutables = ['id','ploidy','kmer_size'])
//@Sortable(includes = ['id'])
class SampleSpecies {
    static { 
        // Register this class with the Kryo framework that serializes and deserializes objects
        // that pass through channels. This allows for caching when this object is used.
        KryoHelper.register(SampleSpecies)
    }

    String id
    int ploidy
    int kmer_size

    // SampleSpecies(String name, int ploidy, int kmer_size){
    //     id = name
    //     this.ploidy = ploidy
    //     this.kmer_size = kmer_size
    // }

    boolean equals(Object o){
        if ( o.is(this) )
            return true;

        if (!(o instanceof SampleSpecies))
            return false;

        try {
            return o.id.equals(id);
        } catch (ClassCastException e)   {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public String toString(){
        return "[ id: $id, ploidy: $ploidy, kmer_size: $kmer_size ]"
    }
}