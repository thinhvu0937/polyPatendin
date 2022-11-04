new Morris.Line({
  // ID of the element in which to draw the chart.
  element: 'myfirstchart',
  lineColors:['red'],
  // Chart data records -- each entry in this array corresponds to a point on
  // the chart.
  data: [
    { year: '2016', value: 210 },
    { year: '2017', value: 674 },
    { year: '2018', value: 1457 },
    { year: '2019', value:	1867 },
    { year: '2020', value: 2677 },
    { year: '2021', value: 5655 }
  ],
  // The name of the data record attribute that contains x-values.
  xkey: 'year',
  // A list of names of data record attributes that contain y-values.
  ykeys: ['value'],
  // Labels for the ykeys -- will be displayed when you hover over the
  // chart.
  labels: ['Value']
});

Morris.Donut({
  element: 'donut-example',
  data: [
    {label: "Download Sales", value: 12},
    {label: "In-Store Sales", value: 30},
    {label: "Mail-Order Sales", value: 20}
  ],
  colors:['orange','#0072f2','red'],
});
