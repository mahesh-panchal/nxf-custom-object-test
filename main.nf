#! /usr/bin/env nextflow 

workflow {
    Channel.of( [ new SampleSpecies('hsapiens',2,31), 'A' ], [ new SampleSpecies('hsapiens',2,35), 'B' ] )
        .groupTuple().view()
}