using Methodica_Exams.Model;
using Methodica_Exams.Services;
using Methodica_Exams.ViewModel;
using System;
using System.Collections.Generic;
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
    /// Lógica de interacción para ProfesorVentana.xaml
    /// </summary>
    public partial class ProfesorVentana : Window
    {
        public ProfesorVentana(usuarios usuarioLogueado)
        {
            InitializeComponent();
            this.DataContext = new ProfesorVM(usuarioLogueado);
        }

        private void AñadirExamenButton_Click(object sender, RoutedEventArgs e)
        {
            long idTema = long.Parse((sender as Button).Tag.ToString());
            (this.DataContext as ProfesorVM).AñadirExamen(idTema);
            Refrescar();

        }

        private void ConstruirExamenButton_Click(object sender, RoutedEventArgs e)
        {
            long idExamen = long.Parse((sender as Button).Tag.ToString());

            (this.DataContext as ProfesorVM).ConstruirExamen(idExamen);

            Refrescar();
        }

        private void EliminarExamenButton_Click(object sender, RoutedEventArgs e)
        {
            long idExamen = long.Parse((sender as Button).Tag.ToString());

            (this.DataContext as ProfesorVM).EliminarExamen(idExamen);

            Refrescar();
        }

        public void Refrescar()
        {
            TemasItemsControl.DataContext = null;
            TemasItemsControl.DataContext = this.DataContext;
        }

        private void CerrarSesionButton_Click(object sender, RoutedEventArgs e)
        {
            
            Login login = new Login();
            login.Show();
            Close();
        }

        private void ActivarExamenButton_Click(object sender, RoutedEventArgs e)
        {
            long idExamen = long.Parse((sender as Button).Tag.ToString());
            (this.DataContext as ProfesorVM).ActivarDesactivarExamen(idExamen);
            Refrescar();
        }
    }
}
