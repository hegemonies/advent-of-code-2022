package puzzles

import inputs.day07Input

data class TreeNode(
    val path: String,
    var size: Int = 0,
    val name: String,
    val isDir: Boolean,
    val parent: TreeNode?,
    val children: MutableList<TreeNode> = mutableListOf(),
)

fun TreeNode.print() {
    val spacesCount = path.removeSuffix("/").split("/").size
    val spaces = " ".repeat(spacesCount * 2)
    val info = if (isDir) "(dir, size=$size)" else "(file, size=$size)"
    println("$spaces- $name $info")
    children.forEach { child -> child.print() }
}

fun TreeNode.calculateSize(): Int {
    children.forEach { child ->
        size += if (isDir) {
            child.calculateSize()
        } else {
            child.size
        }
    }
    return size
}

fun findAtMost100k(root: TreeNode): Int {
    val nodes = mutableListOf<TreeNode>()

    fun TreeNode.findAtMost100k() {
        if (isDir) {
            if (size < 100000) {
                nodes.add(this)
            }

            children.filter { child ->
                child.isDir
            }.forEach { child ->
                child.findAtMost100k()
            }
        }
    }

    root.findAtMost100k()

    return nodes.sumOf { child -> child.size }
}

fun findDirToDelete(root: TreeNode): Int {
    val totalSpace = 70000000
    val needToUpdateSpace = 30000000
    val allDirs = mutableListOf<TreeNode>()

    fun TreeNode.findDir() {
        if (isDir) {
            allDirs.add(this)

            children.filter { child ->
                child.isDir
            }.forEach {  child ->
                child.findDir()
            }
        }
    }

    root.findDir()

    allDirs.sortBy { node ->
        node.size
    }

    val usedSpace = root.size
    val freeSpace = totalSpace - usedSpace

    allDirs.forEach { dir ->
        if (freeSpace + dir.size >= needToUpdateSpace) {
            return dir.size
        }
    }

    return 0
}

fun String.isCommand(): Boolean =
    this.isNotEmpty() && this[0] == '$'

fun String.isNotCommand(): Boolean =
    !this.isCommand()

fun String.getArguments(): String =
    this.drop(5)

sealed class FilesystemElementInfo
data class FileInfo(val size: Int, val name: String) : FilesystemElementInfo()
data class DirInfo(val name: String) : FilesystemElementInfo()

fun String.getFileInfo(): FilesystemElementInfo {
    val words = this.split(" ")
    val info = if (words[0] == "dir") {
        val (_, name) = words
        DirInfo(name)
    } else {
        val (size, name) = words
        FileInfo(size.toInt(), name)
    }
    return info
}

enum class TerminalCommand {
    CD, LS
}

enum class TerminalCDSubcommand {
    TO_ROOT, ONE_LEVEL_UP, ONE_LEVEL_DOWN
}

fun String.toCommand(): TerminalCommand =
    when (this.split(" ").take(2).drop(1)[0]) {
        "cd" -> TerminalCommand.CD
        "ls" -> TerminalCommand.LS
        else -> throw Exception("failed to get command from string")
    }

fun String.toCDSubcommand(): TerminalCDSubcommand =
    when (this) {
        ".." -> TerminalCDSubcommand.ONE_LEVEL_UP
        "/" -> TerminalCDSubcommand.TO_ROOT
        else -> TerminalCDSubcommand.ONE_LEVEL_DOWN
    }

fun parseDay07Input(input: String): TreeNode {
    val lines = input.split("\n")
    var currentIndexLine = 1 // to skip of 'cd /'
    val root = TreeNode(
        path = "/",
        name = "/",
        isDir = true,
        parent = null,
    )
    var currentNode = root

    while (currentIndexLine < lines.size) {
        val line = lines[currentIndexLine]

        if (line.isCommand()) {
            when (line.toCommand()) {
                TerminalCommand.LS -> {
                    // next after $ will be children of current node
                    currentIndexLine++
                    var nextLine = lines[currentIndexLine]
                    while (nextLine.isNotCommand()) {
                        val node = when (val info = nextLine.getFileInfo()) {
                            is DirInfo -> TreeNode(
                                name = info.name,
                                isDir = true,
                                parent = currentNode,
                                path = currentNode.path + "${info.name}/"
                            )

                            is FileInfo -> TreeNode(
                                name = info.name,
                                isDir = false,
                                parent = currentNode,
                                path = currentNode.path + info.name,
                                size = info.size
                            )
                        }
                        currentNode.children.add(node)
                        currentIndexLine++
                        if (currentIndexLine == lines.size) {
                            break
                        }
                        nextLine = lines[currentIndexLine]
                    }
                }

                TerminalCommand.CD -> {
                    val argument = line.getArguments()
                    // change current node
                    when (argument.toCDSubcommand()) {
                        TerminalCDSubcommand.TO_ROOT -> {
                            currentIndexLine++
                            currentNode = root
                        }

                        TerminalCDSubcommand.ONE_LEVEL_UP -> {
                            currentIndexLine++
                            currentNode = currentNode.parent ?: continue
                        }

                        TerminalCDSubcommand.ONE_LEVEL_DOWN -> {
                            currentIndexLine++
                            val child = currentNode.children.find { child ->
                                child.name == argument
                            }
                            if (child != null) {
                                currentNode = child
                            }
                        }
                    }
                }
            }
        }
    }

    return root
}

/**
 * https://adventofcode.com/2022/day/7
 *
 * --- Day 7: No Space Left On Device ---
 * You can hear birds chirping and raindrops hitting leaves as the expedition proceeds. Occasionally, you can even hear much louder sounds in the distance; how big do the animals get out here, anyway?
 *
 * The device the Elves gave you has problems with more than just its communication system. You try to run a system update:
 *
 * $ system-update --please --pretty-please-with-sugar-on-top
 * Error: No space left on device
 * Perhaps you can delete some files to make space for the update?
 *
 * You browse around the filesystem to assess the situation and save the resulting terminal output (your puzzle input). For example:
 *
 * $ cd /
 * $ ls
 * dir a
 * 14848514 b.txt
 * 8504156 c.dat
 * dir d
 * $ cd a
 * $ ls
 * dir e
 * 29116 f
 * 2557 g
 * 62596 h.lst
 * $ cd e
 * $ ls
 * 584 i
 * $ cd ..
 * $ cd ..
 * $ cd d
 * $ ls
 * 4060174 j
 * 8033020 d.log
 * 5626152 d.ext
 * 7214296 k
 * The filesystem consists of a tree of files (plain data) and directories (which can contain other directories or files). The outermost directory is called /. You can navigate around the filesystem, moving into or out of directories and listing the contents of the directory you're currently in.
 *
 * Within the terminal output, lines that begin with $ are commands you executed, very much like some modern computers:
 *
 * cd means change directory. This changes which directory is the current directory, but the specific result depends on the argument:
 * cd x moves in one level: it looks in the current directory for the directory named x and makes it the current directory.
 * cd .. moves out one level: it finds the directory that contains the current directory, then makes that directory the current directory.
 * cd / switches the current directory to the outermost directory, /.
 * ls means list. It prints out all of the files and directories immediately contained by the current directory:
 * 123 abc means that the current directory contains a file named abc with size 123.
 * dir xyz means that the current directory contains a directory named xyz.
 * Given the commands and output in the example above, you can determine that the filesystem looks visually like this:
 *
 * - / (dir)
 *   - a (dir)
 *     - e (dir)
 *       - i (file, size=584)
 *     - f (file, size=29116)
 *     - g (file, size=2557)
 *     - h.lst (file, size=62596)
 *   - b.txt (file, size=14848514)
 *   - c.dat (file, size=8504156)
 *   - d (dir)
 *     - j (file, size=4060174)
 *     - d.log (file, size=8033020)
 *     - d.ext (file, size=5626152)
 *     - k (file, size=7214296)
 * Here, there are four directories: / (the outermost directory), a and d (which are in /), and e (which is in a). These directories also contain files of various sizes.
 *
 * Since the disk is full, your first step should probably be to find directories that are good candidates for deletion. To do this, you need to determine the total size of each directory. The total size of a directory is the sum of the sizes of the files it contains, directly or indirectly. (Directories themselves do not count as having any intrinsic size.)
 *
 * The total sizes of the directories above can be found as follows:
 *
 * The total size of directory e is 584 because it contains a single file i of size 584 and no other directories.
 * The directory a has total size 94853 because it contains files f (size 29116), g (size 2557), and h.lst (size 62596), plus file i indirectly (a contains e which contains i).
 * Directory d has total size 24933642.
 * As the outermost directory, / contains every file. Its total size is 48381165, the sum of the size of every file.
 * To begin, find all of the directories with a total size of at most 100000, then calculate the sum of their total sizes. In the example above, these directories are a and e; the sum of their total sizes is 95437 (94853 + 584). (As in this example, this process can count files more than once!)
 *
 * Find all of the directories with a total size of at most 100000. What is the sum of the total sizes of those directories?
 */
fun solveDay07Task(input: String): Int {
    val root = parseDay07Input(input)
    root.calculateSize()
    return findAtMost100k(root)
}

/**
 * --- Part Two ---
 * Now, you're ready to choose a directory to delete.
 *
 * The total disk space available to the filesystem is 70000000. To run the update, you need unused space of at least 30000000. You need to find a directory you can delete that will free up enough space to run the update.
 *
 * In the example above, the total size of the outermost directory (and thus the total amount of used space) is 48381165; this means that the size of the unused space must currently be 21618835, which isn't quite the 30000000 required by the update. Therefore, the update still requires a directory with total size of at least 8381165 to be deleted before it can run.
 *
 * To achieve this, you have the following options:
 *
 * Delete directory e, which would increase unused space by 584.
 * Delete directory a, which would increase unused space by 94853.
 * Delete directory d, which would increase unused space by 24933642.
 * Delete directory /, which would increase unused space by 48381165.
 * Directories e and a are both too small; deleting them would not free up enough space. However, directories d and / are both big enough! Between these, choose the smallest: d, increasing unused space by 24933642.
 *
 * Find the smallest directory that, if deleted, would free up enough space on the filesystem to run the update. What is the total size of that directory?
 */
fun solveDay07Part2Task(input: String): Int {
    val root = parseDay07Input(input)
    root.calculateSize()
    return findDirToDelete(root)
}

fun runSample() {
    val root = TreeNode(
        path = "/",
        name = "/",
        isDir = true,
        parent = null,
        children = mutableListOf()
    )

    val a = TreeNode(
        path = "/a/",
        name = "a",
        isDir = true,
        parent = root,
        children = mutableListOf()
    )
    val e = TreeNode(
        path = "/a/e/",
        name = "e",
        isDir = true,
        parent = a,
        children = mutableListOf()
    )
    val i = TreeNode(
        path = "/a/e/i",
        name = "i",
        isDir = false,
        parent = e,
        size = 584
    )
    e.children.add(i)
    val f = TreeNode(
        path = "/a/f",
        name = "f",
        isDir = false,
        parent = a,
        size = 29116
    )
    val g = TreeNode(
        path = "/a/g",
        name = "g",
        isDir = false,
        parent = a,
        size = 2557
    )
    val hlst = TreeNode(
        path = "/a/h.lst",
        name = "h.lst",
        isDir = false,
        parent = a,
        size = 62596
    )
    a.children.addAll(listOf(e, f, g, hlst))
    val b = TreeNode(
        path = "/b.txt",
        name = "b.txt",
        isDir = false,
        parent = root,
        size = 14848514
    )
    val c = TreeNode(
        path = "/c.txt",
        name = "c.txt",
        isDir = false,
        parent = root,
        size = 8504156
    )
    val d = TreeNode(
        path = "/d/",
        name = "d",
        isDir = true,
        parent = root,
        children = mutableListOf()
    )
    val j = TreeNode(
        path = "/d/j",
        name = "j",
        isDir = false,
        parent = d,
        size = 4060174
    )
    val dlog = TreeNode(
        path = "/d/d.log",
        name = "d.log",
        isDir = false,
        parent = d,
        size = 8033020
    )
    val dext = TreeNode(
        path = "/d/d.ext",
        name = "d.ext",
        isDir = false,
        parent = d,
        size = 5626152
    )
    val k = TreeNode(
        path = "/d/k",
        name = "j",
        isDir = false,
        parent = d,
        size = 7214296
    )
    d.children.addAll(listOf(j, dlog, dext, k))
    root.children.addAll(listOf(a, b, c, d))
    root.print()
    root.calculateSize()
    println()
    root.print()
    println()
    println(findAtMost100k(root))
}

fun main() {
    println("day 07 = ${solveDay07Task(day07Input)}")
    println("day 07 part 2 = ${solveDay07Part2Task(day07Input)}")
}
