import groovy.transform.Immutable
import nextflow.io.ValueObject
import nextflow.util.KryoHelper
import nextflow.util.ArrayBag

@ValueObject
@Immutable(copyWith=true, knownImmutables = ['id','ploidy','kmer_size'])
class SampleSpecies {
    static { 
        // Register this class with the Kryo framework that serializes and deserializes objects
        // that pass through channels. This allows for caching when this object is used.
        KryoHelper.register(SampleSpecies)
    }

    String id
    int ploidy
    int kmer_size

    public String toString(){
        return "[ id: $id, ploidy: $ploidy, kmer_size: $kmer_size ]"
    }
}