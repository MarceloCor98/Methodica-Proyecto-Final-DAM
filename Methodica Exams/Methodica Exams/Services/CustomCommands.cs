using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Methodica_Exams.Services
{
    public static class CustomCommands
    {
        public static readonly RoutedUICommand EliminarPregunta = new RoutedUICommand
        (
            "EliminarPregunta",
            "EliminarPregunta",
            typeof(CustomCommands),
            null
        );

        public static readonly RoutedUICommand AñadirPregunta = new RoutedUICommand
        (
            "AñadirPregunta",
            "AñadirPregunta",
            typeof(CustomCommands),
            null
        );
    }
}
