using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Methodica_Exams.View
{
    /// <summary>
    /// Lógica de interacción para AlumnoVentana.xaml
    /// </summary>
    public partial class AlumnoVentana : Window
    {
        methodicadbEntities contexto = new methodicadbEntities();
        public AlumnoVentana()
        {
            InitializeComponent();
        }
    }
}
