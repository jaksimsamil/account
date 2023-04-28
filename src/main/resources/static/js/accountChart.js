
$(function() {
  // List sorted by month
    const dataset = {
      labels: expenseList.map(row => row.aggDate),
      datasets: [
        {
          label:'고정지출',
          data: expenseList.map(row => row.fixValue),
          borderColor: '#36A2EB',
          backgroundColor: '#36A2EB'
        },
        {
          label: '가변지출',
          data: expenseList.map(row => row.varValue),
          borderColor: '#8c0863',
          backgroundColor: '#8c0863'
        },
        {
            label: '총 지출',
            data: expenseList.map(row => row.fixValue + row.varValue),
            borderColor: '#11b893',
            backgroundColor: '#11b893'
        }
      ]
    };
    new Chart( document.getElementById('accountChart'), {
            type: 'line',
            data:dataset});}
);