# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /cygdrive/c/Users/sofas/.CLion2019.3/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/sofas/.CLion2019.3/system/cygwin_cmake/bin/cmake.exe -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/ex.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/ex.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/ex.dir/flags.make

CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o: CMakeFiles/ex.dir/flags.make
CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o: ../DataStructuresAndAlgorithmAnalysisInC/chapter1.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o   -c /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/DataStructuresAndAlgorithmAnalysisInC/chapter1.c

CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/DataStructuresAndAlgorithmAnalysisInC/chapter1.c > CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.i

CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/DataStructuresAndAlgorithmAnalysisInC/chapter1.c -o CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.s

# Object files for target ex
ex_OBJECTS = \
"CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o"

# External object files for target ex
ex_EXTERNAL_OBJECTS =

ex.exe: CMakeFiles/ex.dir/DataStructuresAndAlgorithmAnalysisInC/chapter1.c.o
ex.exe: CMakeFiles/ex.dir/build.make
ex.exe: CMakeFiles/ex.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable ex.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/ex.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/ex.dir/build: ex.exe

.PHONY : CMakeFiles/ex.dir/build

CMakeFiles/ex.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/ex.dir/cmake_clean.cmake
.PHONY : CMakeFiles/ex.dir/clean

CMakeFiles/ex.dir/depend:
	cd /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug /cygdrive/c/Users/sofas/Documents/GitHub/Ano2Semestre2/AlgC/bibliografia/ex/cmake-build-debug/CMakeFiles/ex.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/ex.dir/depend

