$(() => {
	$.ajax({
			url: '/Bfast/Dashboard/Giorno',
			method: 'get'
		}).done((Giorno) => {
				alert(Giorno);

			})
	$.ajax({
			url: '/Bfast/Dashboard/Mese',
			method: 'get'
		}).done((Mese) => {
				alert(Mese);
			})
	$.ajax({
			url: '/Bfast/Conf',
			method: 'get'
		}).done((Ordini) => {
				Alert(Ordini)
			})

}) 