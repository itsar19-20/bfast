$(() => {
	$.ajax({
			url: '/Bfast/Dashboard/Giorno',
			method: 'get'
		}).done((Giorno) => {
				alert(Giorno);

			})
	$.ajax({
			url: '/Bfast/StatisticheMensili',
			method: 'get'
		}).done((Mese) => {
				alert(Mese);
			})
	$.ajax({
			url: '/Bfast/OrdiniConfermare',
			method: 'get'
		}).done((Ordini) => {
				Alert(Ordini)
			})

}) 