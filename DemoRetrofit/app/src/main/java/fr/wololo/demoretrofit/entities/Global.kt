package fr.wololo.demoretrofit.entities

data class Global(var nbTotal:Int,var items:List<Producteur>)

data class Producteur(var id:Int?,var raisonSociale:String?,var denominationcourante:String?)