
$(function() {
        function stringToDate(aggDate) {
                var stringAggDate = new Date(aggDate);
                return "".concat(stringAggDate.getFullYear()).concat(".")
                                .concat(stringAggDate.getMonth()+1).concat(".");
        };
  // List sorted by month
    const dataset = {
      labels: expenseList.map(row => stringToDate(row.aggDate)),
      datasets: [
        {
          label: fix,
          data: expenseList.map(row => row.fix),
          borderColor: '#36A2EB',
          backgroundColor: '#36A2EB'
        },
        {
          label: fluct,
          data: expenseList.map(row => row.fluct),
          borderColor: '#8c0863',
          backgroundColor: '#8c0863'
        },
        {
          label: etc,
          data: expenseList.map(row => row.etc),
          borderColor: '#8c7863',
          backgroundColor: '#8c7863'
        },
        {
            label: total,
            data: expenseList.map(row => row.fix + row.fluct + row.etc),
            borderColor: '#11b893',
            backgroundColor: '#11b893'
        }
      ]
    };
    new Chart( document.getElementById('accountChart'), {
            type: 'line',
            data: dataset,
            options: {
                responsive: true,
                    scales: {
                        y: {
                            min: 0,
                            ticks: { stepSize: 300000}
                        }
                    }
                }
        });}
);