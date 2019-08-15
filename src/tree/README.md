1. root is one of a, b:
2. root is not any of a, b:
    case 2.1 - if onoe of a, b in any of the left/right subtree, return null.
    case 2.2 - only one of a, b in left/right subtree, return itself.
    case 2.3 - both of a, b in left/right subtree.
        case 2.3.1 - the 2 nodes in different subtrees, root
        case 2.3.2 - the 2 nodes in the same subtree, return the non-null subproblem result.