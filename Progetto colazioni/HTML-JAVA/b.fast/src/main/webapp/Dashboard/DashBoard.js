$(() => {
	$.ajax({
			url: '/Bfast/StatisticheGiornaliere',
			method: 'get'
		})
			.done((Giorno) => {
				document.getElementById("Numero1").innerHTML = Giorno;

			})
	$.ajax({
			url: '/Bfast/StatisticheMensili',
			method: 'get'
		})
			.done((Mese) => {
				document.getElementById("Numero2").innerHTML = Giorno;

			})
	$.ajax({
			url: '/Bfast/OrdiniConfermare',
			method: 'get'
		})
			.done((Ordini) => {
				document.getElementById("Numero3").innerHTML = Giorno;

			})

}) 