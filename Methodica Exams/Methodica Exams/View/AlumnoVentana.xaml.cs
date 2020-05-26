using Methodica_Exams.Model;
using Methodica_Exams.Services;
using Methodica_Exams.ViewModel;
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
        public AlumnoVentana(usuarios usuarioLogueado)
        {
            InitializeComponent();
            this.DataContext = new AlumnoVM(usuarioLogueado);
            
        }
        
        private void CerrarSesionButton_Click(object sender, RoutedEventArgs e)
        {

            Login login = new Login();
            login.Show();
            Close();
        }

        private void CursosMatriculadosListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            (this.DataContext as AlumnoVM).CargarNotas();
            (this.DataContext as AlumnoVM).CargarExamenes();
            ExamenesItemsControl.DataContext = (this.DataContext as AlumnoVM).ExamenesActivos;
        }

        private void RealizarExamen_Click(object sender, RoutedEventArgs e)
        {
            long idExamen = long.Parse((sender as Button).Tag.ToString());
            (this.DataContext as AlumnoVM).RealizarExamen(idExamen);
                
            
        }
    }
}
