#! /usr/bin/env nextflow 

workflow {
    Channel.of( 
        [ new SampleSpecies(id:'hsapiens',ploidy:2,kmer_size:31), 'A' ], 
        [ new SampleSpecies(id:'hsapiens',ploidy:2,kmer_size:31), 'B' ] 
    ).groupTuple()
        .view()
}